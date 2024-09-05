# flutter_android_aidl_example

It is AIDL Example app in Flutter. 
Steps to generate AIDL folder in Android

1. Create a new file named IMyAidlInterface.aidl app/src/main/{packageName}/IMyAidlInterface.aidl directory.
2. add below code in app.gradle
   android {
    ...
    sourceSets {
        main {
            aidl.srcDirs = ['src']
        }
    }
  }
3. add below line in gradle.properties
   android.defaults.buildfeatures.aidl=true

4. run the code after flutter clean and flutter pub get commands executed



## Getting Started

This project is a starting point for a Flutter application.

A few resources to get you started if this is your first Flutter project:

- [Lab: Write your first Flutter app](https://docs.flutter.dev/get-started/codelab)
- [Cookbook: Useful Flutter samples](https://docs.flutter.dev/cookbook)

For help getting started with Flutter development, view the
[online documentation](https://docs.flutter.dev/), which offers tutorials,
samples, guidance on mobile development, and a full API reference.
