package com.mywardrobechoices.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.mywardrobechoices.R
import com.mywardrobechoices.models.Character
import com.mywardrobechoices.models.CharacterStyle

class CharacterPreviewView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var character: Character = Character()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    fun updateCharacter(newCharacter: Character) {
        character = newCharacter
        invalidate() // Trigger a redraw
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        // First draw background to fill entire container
        drawBackground(canvas)
        
        // Then draw character scaled and centered appropriately
        val centerX = width / 2f
        val centerY = height / 2f
        val scaleX = width / 400f // Scale to fit container width
        val scaleY = height / 300f // Scale to fit container height
        val scale = minOf(scaleX, scaleY) // Use smaller scale to fit entirely in container
        
        // Calculate character dimensions after scaling
        val characterWidth = 400 * scale
        val characterHeight = 300 * scale
        
        canvas.save()
        // Center the character in the container
        canvas.translate(centerX - characterWidth / 2, centerY - characterHeight / 2)
        canvas.scale(scale, scale)
        
        // Draw hair first (behind everything)
        drawHair(canvas)
        
        // Draw character base
        drawCharacterBase(canvas)
        
        // Draw eyes (on face)
        drawEyes(canvas)
        
        // Draw clothing layers
        drawClothing(canvas)
        
        // Draw accessories
        drawAccessories(canvas)
        
        // Draw hat (on top)
        drawHat(canvas)
        
        // Draw pet
        drawPet(canvas)
        
        canvas.restore()
    }
    
    private fun drawBackground(canvas: Canvas) {
        val backgroundDrawable = when (character.background) {
            41 -> ContextCompat.getDrawable(context, R.drawable.background_beach)
            42 -> ContextCompat.getDrawable(context, R.drawable.background_park)
            43 -> ContextCompat.getDrawable(context, R.drawable.background_park)
            else -> ContextCompat.getDrawable(context, R.drawable.background_park)
        }
        
        backgroundDrawable?.let { drawable ->
            // Fill entire container with background, maintaining aspect ratio
            val drawableWidth = drawable.intrinsicWidth
            val drawableHeight = drawable.intrinsicHeight
            val scaleX = width.toFloat() / drawableWidth
            val scaleY = height.toFloat() / drawableHeight
            val scale = maxOf(scaleX, scaleY) // Scale to fill container completely
            
            val scaledWidth = (drawableWidth * scale).toInt()
            val scaledHeight = (drawableHeight * scale).toInt()
            val offsetX = (width - scaledWidth) / 2
            val offsetY = (height - scaledHeight) / 2
            
            drawable.setBounds(offsetX, offsetY, offsetX + scaledWidth, offsetY + scaledHeight)
            drawable.draw(canvas)
        }
    }
    
    private fun drawCharacterBase(canvas: Canvas) {
        val baseDrawable = when (character.style) {
            CharacterStyle.STYLE_B -> ContextCompat.getDrawable(context, R.drawable.character_base_boy)
            CharacterStyle.STYLE_A -> ContextCompat.getDrawable(context, R.drawable.character_base_girl)
        }
        
        baseDrawable?.let { drawable ->
            drawable.setBounds(0, 0, 200, 300)
            drawable.draw(canvas)
        }
    }
    
    private fun drawClothing(canvas: Canvas) {
        // Draw top
        val topDrawable = when (character.outfit.top) {
            16 -> ContextCompat.getDrawable(context, R.drawable.top_pink_dress)
            17 -> ContextCompat.getDrawable(context, R.drawable.top_blue_shirt)
            18 -> ContextCompat.getDrawable(context, R.drawable.top_pixar_rainbow)
            19 -> ContextCompat.getDrawable(context, R.drawable.top_blue_shirt)
            20 -> ContextCompat.getDrawable(context, R.drawable.top_blue_shirt)
            21 -> ContextCompat.getDrawable(context, R.drawable.top_pixar_rainbow)
            else -> ContextCompat.getDrawable(context, R.drawable.top_blue_shirt)
        }
        
        topDrawable?.let { drawable ->
            drawable.setBounds(0, 0, 200, 300)
            drawable.draw(canvas)
        }
        
        // Draw bottom (only if not wearing a dress)
        if (character.outfit.top != 16) {
            val bottomDrawable = ContextCompat.getDrawable(context, R.drawable.bottom_blue_jeans)
            bottomDrawable?.let { drawable ->
                drawable.setBounds(0, 0, 200, 300)
                drawable.draw(canvas)
            }
        }
        
        // Draw shoes
        val shoesDrawable = when (character.outfit.shoes) {
            28 -> ContextCompat.getDrawable(context, R.drawable.shoes_pixar_sneakers)
            else -> ContextCompat.getDrawable(context, R.drawable.shoes_sneakers)
        }
        shoesDrawable?.let { drawable ->
            drawable.setBounds(0, 0, 200, 300)
            drawable.draw(canvas)
        }
    }
    
    private fun drawHair(canvas: Canvas) {
        val hairDrawable = when (character.hair) {
            8 -> ContextCompat.getDrawable(context, R.drawable.hair_pixar_curly)
            9 -> ContextCompat.getDrawable(context, R.drawable.hair_pixar_wavy)
            11 -> ContextCompat.getDrawable(context, R.drawable.hair_pixar_wavy)
            12 -> ContextCompat.getDrawable(context, R.drawable.hair_pixar_curly)
            10 -> ContextCompat.getDrawable(context, R.drawable.hair_short_black)
            else -> when (character.style) {
                CharacterStyle.STYLE_B -> ContextCompat.getDrawable(context, R.drawable.hair_short_black)
                CharacterStyle.STYLE_A -> ContextCompat.getDrawable(context, R.drawable.hair_long_brown)
            }
        }
        
        hairDrawable?.let { drawable ->
            drawable.setBounds(0, 0, 200, 300)
            drawable.draw(canvas)
        }
    }
    
    private fun drawEyes(canvas: Canvas) {
        val eyesDrawable = when (character.eyes) {
            14 -> ContextCompat.getDrawable(context, R.drawable.eyes_pixar_blue)
            15 -> ContextCompat.getDrawable(context, R.drawable.eyes_pixar_green)
            else -> ContextCompat.getDrawable(context, R.drawable.eyes_brown)
        }
        eyesDrawable?.let { drawable ->
            drawable.setBounds(0, 0, 200, 300)
            drawable.draw(canvas)
        }
    }
    
    private fun drawAccessories(canvas: Canvas) {
        if (character.accessories.isNotEmpty()) {
            val accessoryDrawable = ContextCompat.getDrawable(context, R.drawable.accessory_sunglasses)
            accessoryDrawable?.let { drawable ->
                drawable.setBounds(0, 0, 200, 300)
                drawable.draw(canvas)
            }
        }
    }
    
    private fun drawHat(canvas: Canvas) {
        character.outfit.hat?.let {
            val hatDrawable = ContextCompat.getDrawable(context, R.drawable.hat_baseball_cap)
            hatDrawable?.let { drawable ->
                drawable.setBounds(0, 0, 200, 300)
                drawable.draw(canvas)
            }
        }
    }
    
    private fun drawPet(canvas: Canvas) {
        character.pet?.let {
            val petDrawable = when (it.id) {
                38 -> ContextCompat.getDrawable(context, R.drawable.pet_cat)
                else -> ContextCompat.getDrawable(context, R.drawable.pet_dog)
            }
            
            petDrawable?.let { drawable ->
                // Position pet next to character
                canvas.save()
                canvas.translate(220f, 200f)
                drawable.setBounds(0, 0, 80, 80)
                drawable.draw(canvas)
                canvas.restore()
            }
        }
    }
}