# My Wardrobe Choices - Android App

## Overview
This is a complete Android application for character customization where users can:
- Choose between boy and girl characters
- Customize face, hair, eyes, clothing, accessories, and pets
- Change backgrounds and environments
- Unlock new items through gameplay progression
- Save and generate random outfits
- Earn experience points and coins

## Features Implemented

### Core Features
✅ **Character Customization**
- Face options for both genders
- Hair styles (gender-specific)
- Eye colors
- Clothing (tops, bottoms, shoes, hats)
- Accessories (jewelry, glasses, bags)
- Pets (dogs, cats, birds)
- Background environments

✅ **Progression System**
- Level-based unlocks
- Experience points for actions
- Coin rewards
- Boy character unlocks at level 2
- Advanced items unlock at higher levels

✅ **Interactive Features**
- Random outfit generator
- Outfit saving system
- Category-based item selection
- Visual feedback with emojis
- Progress tracking

### Technical Implementation
- **Architecture**: MVVM pattern with Repository
- **Data Persistence**: SharedPreferences for game progress
- **UI**: Material Design with RecyclerViews
- **Language**: Kotlin
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

## Project Structure
```
app/
├── src/main/
│   ├── java/com/mywardrobechoices/
│   │   ├── MainActivity.kt                 # Main activity
│   │   ├── adapters/
│   │   │   ├── CategoryAdapter.kt          # Category selection
│   │   │   └── WardrobeItemAdapter.kt      # Item selection
│   │   ├── data/
│   │   │   └── WardrobeRepository.kt       # Data source
│   │   ├── models/
│   │   │   ├── Character.kt                # Character data model
│   │   │   ├── WardrobeItem.kt            # Item data model
│   │   │   └── GameProgress.kt            # Progress tracking
│   │   └── utils/
│   │       ├── PreferencesManager.kt      # Data persistence
│   │       └── GameConstants.kt           # Game constants
│   ├── res/
│   │   ├── layout/                        # UI layouts
│   │   ├── values/                        # Colors, strings, themes
│   │   └── xml/                          # Backup rules
│   └── AndroidManifest.xml
├── build.gradle                          # App dependencies
└── proguard-rules.pro                    # ProGuard rules
```

## How to Build and Run

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+
- Kotlin support

### Build Steps
1. **Open in Android Studio**
   ```bash
   # Open the project folder in Android Studio
   # File -> Open -> Select the project directory
   ```

2. **Sync Gradle**
   - Android Studio will automatically prompt to sync
   - Or manually: Tools -> Gradle -> Sync Project

3. **Build the App**
   ```bash
   # Via Android Studio: Build -> Make Project
   # Or via command line:
   ./gradlew assembleDebug
   ```

4. **Run on Device/Emulator**
   - Connect Android device or start emulator
   - Click "Run" button in Android Studio
   - Or via command line: `./gradlew installDebug`

### Alternative Build (Command Line)
```bash
# Build debug APK
./gradlew assembleDebug

# Install on connected device
./gradlew installDebug

# Build and install in one step
./gradlew installDebug
```

## Game Progression System

### Level Unlocks
- **Level 1**: Girl character, basic items
- **Level 2**: Boy character unlocked
- **Level 3**: Advanced hair styles
- **Level 4**: Accessories (jewelry, glasses)
- **Level 5**: Pets available
- **Level 6+**: Premium backgrounds

### Experience Points
- Change item: +5 XP
- Generate random outfit: +10 XP
- Save outfit: +20 XP

### Coin System
- Change item: +2 coins
- Random outfit: +5 coins
- Save outfit: +10 coins

## Future Enhancements
- [ ] Visual character preview with actual images
- [ ] Shop system for purchasing items with coins
- [ ] Social features (share outfits)
- [ ] More character types and customization options
- [ ] Animated character preview
- [ ] Sound effects and music
- [ ] Achievement system
- [ ] Outfit contests and challenges

## Troubleshooting

### Common Issues
1. **Build Errors**: Ensure Android SDK is properly installed
2. **Gradle Sync Issues**: Check internet connection and Gradle version
3. **App Crashes**: Check device API level (minimum 24)

### Debug Mode
The app includes extensive logging and toast messages for debugging gameplay progression.

## License
This project is created as a demonstration of Android app development for character customization games.