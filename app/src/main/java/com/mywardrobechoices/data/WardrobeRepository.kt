package com.mywardrobechoices.data

import com.mywardrobechoices.R
import com.mywardrobechoices.models.*

class WardrobeRepository {
    
    fun getBodyOptions(): List<WardrobeItem> {
        return listOf(
            WardrobeItem(1, "Style A", ItemCategory.BODY, CharacterStyle.STYLE_A, R.drawable.character_base_girl),
            WardrobeItem(2, "Style B", ItemCategory.BODY, CharacterStyle.STYLE_B, R.drawable.character_base_boy, unlockLevel = 2)
        )
    }
    
    fun getFaceOptions(style: CharacterStyle): List<WardrobeItem> {
        return when (style) {
            CharacterStyle.STYLE_A -> listOf(
                WardrobeItem(1, "Sweet Face", ItemCategory.FACE, CharacterStyle.STYLE_A, R.drawable.character_base_girl),
                WardrobeItem(2, "Cute Face", ItemCategory.FACE, CharacterStyle.STYLE_A, R.drawable.character_base_girl),
                WardrobeItem(3, "Happy Face", ItemCategory.FACE, CharacterStyle.STYLE_A, R.drawable.character_base_girl)
            )
            CharacterStyle.STYLE_B -> listOf(
                WardrobeItem(4, "Cool Face", ItemCategory.FACE, CharacterStyle.STYLE_B, R.drawable.character_base_boy),
                WardrobeItem(5, "Friendly Face", ItemCategory.FACE, CharacterStyle.STYLE_B, R.drawable.character_base_boy),
                WardrobeItem(6, "Brave Face", ItemCategory.FACE, CharacterStyle.STYLE_B, R.drawable.character_base_boy)
            )
        }
    }
    
    fun getHairOptions(style: CharacterStyle): List<WardrobeItem> {
        return when (style) {
            CharacterStyle.STYLE_A -> listOf(
                WardrobeItem(7, "Flowing Hair", ItemCategory.HAIR, CharacterStyle.STYLE_A, R.drawable.hair_long_brown),
                WardrobeItem(8, "Bouncy Curls", ItemCategory.HAIR, CharacterStyle.STYLE_A, R.drawable.hair_pixar_curly, unlockLevel = 3),
                WardrobeItem(9, "Magical Waves", ItemCategory.HAIR, CharacterStyle.STYLE_A, R.drawable.hair_pixar_wavy, unlockLevel = 3)
            )
            CharacterStyle.STYLE_B -> listOf(
                WardrobeItem(10, "Neat Style", ItemCategory.HAIR, CharacterStyle.STYLE_B, R.drawable.hair_short_black),
                WardrobeItem(11, "Fun Spikes", ItemCategory.HAIR, CharacterStyle.STYLE_B, R.drawable.hair_pixar_wavy, unlockLevel = 3),
                WardrobeItem(12, "Cool Waves", ItemCategory.HAIR, CharacterStyle.STYLE_B, R.drawable.hair_pixar_curly, unlockLevel = 3)
            )
        }
    }
    
    fun getEyeOptions(): List<WardrobeItem> {
        return listOf(
            WardrobeItem(13, "Warm Brown Eyes", ItemCategory.EYES, CharacterStyle.STYLE_A, R.drawable.eyes_brown),
            WardrobeItem(14, "Ocean Blue Eyes", ItemCategory.EYES, CharacterStyle.STYLE_A, R.drawable.eyes_pixar_blue),
            WardrobeItem(15, "Forest Green Eyes", ItemCategory.EYES, CharacterStyle.STYLE_A, R.drawable.eyes_pixar_green)
        )
    }
    
    fun getTopOptions(style: CharacterStyle): List<WardrobeItem> {
        return listOf(
            WardrobeItem(16, "Princess Dress", ItemCategory.TOP, CharacterStyle.STYLE_A, R.drawable.top_pink_dress),
            WardrobeItem(17, "Star Shirt", ItemCategory.TOP, CharacterStyle.STYLE_A, R.drawable.top_blue_shirt),
            WardrobeItem(18, "Rainbow Top", ItemCategory.TOP, CharacterStyle.STYLE_A, R.drawable.top_pixar_rainbow, unlockLevel = 4),
            WardrobeItem(19, "Adventure Shirt", ItemCategory.TOP, CharacterStyle.STYLE_B, R.drawable.top_blue_shirt),
            WardrobeItem(20, "Hero Hoodie", ItemCategory.TOP, CharacterStyle.STYLE_B, R.drawable.top_blue_shirt),
            WardrobeItem(21, "Magic Jacket", ItemCategory.TOP, CharacterStyle.STYLE_B, R.drawable.top_pixar_rainbow, unlockLevel = 4)
        )
    }
    
    fun getBottomOptions(style: CharacterStyle): List<WardrobeItem> {
        return listOf(
            WardrobeItem(22, "Comfy Jeans", ItemCategory.BOTTOM, CharacterStyle.STYLE_A, R.drawable.bottom_blue_jeans),
            WardrobeItem(23, "Twirly Skirt", ItemCategory.BOTTOM, CharacterStyle.STYLE_A, R.drawable.bottom_blue_jeans),
            WardrobeItem(24, "Stretchy Leggings", ItemCategory.BOTTOM, CharacterStyle.STYLE_A, R.drawable.bottom_blue_jeans),
            WardrobeItem(25, "Adventure Jeans", ItemCategory.BOTTOM, CharacterStyle.STYLE_B, R.drawable.bottom_blue_jeans),
            WardrobeItem(26, "Active Shorts", ItemCategory.BOTTOM, CharacterStyle.STYLE_B, R.drawable.bottom_blue_jeans),
            WardrobeItem(27, "Explorer Pants", ItemCategory.BOTTOM, CharacterStyle.STYLE_B, R.drawable.bottom_blue_jeans)
        )
    }
    
    fun getShoeOptions(): List<WardrobeItem> {
        return listOf(
            WardrobeItem(28, "Magic Sneakers", ItemCategory.SHOES, CharacterStyle.STYLE_A, R.drawable.shoes_pixar_sneakers),
            WardrobeItem(29, "Adventure Boots", ItemCategory.SHOES, CharacterStyle.STYLE_A, R.drawable.shoes_sneakers),
            WardrobeItem(30, "Sunny Sandals", ItemCategory.SHOES, CharacterStyle.STYLE_A, R.drawable.shoes_sneakers)
        )
    }
    
    fun getHatOptions(): List<WardrobeItem> {
        return listOf(
            WardrobeItem(31, "Magic Cap", ItemCategory.HAT, CharacterStyle.STYLE_A, R.drawable.hat_baseball_cap),
            WardrobeItem(32, "Cozy Beanie", ItemCategory.HAT, CharacterStyle.STYLE_A, R.drawable.hat_baseball_cap),
            WardrobeItem(33, "Sunny Hat", ItemCategory.HAT, CharacterStyle.STYLE_A, R.drawable.hat_baseball_cap)
        )
    }
    
    fun getAccessoryOptions(): List<WardrobeItem> {
        return listOf(
            WardrobeItem(34, "Sparkly Necklace", ItemCategory.ACCESSORY, CharacterStyle.STYLE_A, R.drawable.accessory_sunglasses, unlockLevel = 4),
            WardrobeItem(35, "Cool Sunglasses", ItemCategory.ACCESSORY, CharacterStyle.STYLE_A, R.drawable.accessory_sunglasses, unlockLevel = 4),
            WardrobeItem(36, "Time Watch", ItemCategory.ACCESSORY, CharacterStyle.STYLE_A, R.drawable.accessory_sunglasses, unlockLevel = 4)
        )
    }
    
    fun getPetOptions(): List<WardrobeItem> {
        return listOf(
            WardrobeItem(37, "Loyal Puppy", ItemCategory.PET, CharacterStyle.STYLE_A, R.drawable.pet_dog, unlockLevel = 5),
            WardrobeItem(38, "Cuddly Kitten", ItemCategory.PET, CharacterStyle.STYLE_A, R.drawable.pet_cat, unlockLevel = 5),
            WardrobeItem(39, "Singing Bird", ItemCategory.PET, CharacterStyle.STYLE_A, R.drawable.pet_dog, unlockLevel = 5)
        )
    }
    
    fun getBackgroundOptions(): List<WardrobeItem> {
        return listOf(
            WardrobeItem(40, "Magical Park", ItemCategory.BACKGROUND, CharacterStyle.STYLE_A, R.drawable.background_park),
            WardrobeItem(41, "Sunny Beach", ItemCategory.BACKGROUND, CharacterStyle.STYLE_A, R.drawable.background_beach),
            WardrobeItem(42, "Busy City", ItemCategory.BACKGROUND, CharacterStyle.STYLE_A, R.drawable.background_park, unlockLevel = 6),
            WardrobeItem(43, "Enchanted Forest", ItemCategory.BACKGROUND, CharacterStyle.STYLE_A, R.drawable.background_park, unlockLevel = 6)
        )
    }
}