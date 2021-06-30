## react-native-utils-scale
Provide solutions to make your app flexible for different screen sizes, different devices.
## Getting started

```js 
  yarn add react-native-utils-scale
```
or

```js
  npm i react-native-utils-scale
```
### RN Version < 0.60
```js
    react-native link react-native-utils-scale
```
### IOS
```js
    cd ios && pod install
```

### Jest setup
```js
    jest.mock('react-native-utils-scale', () => {
        const UtilsScale = require('react-native-utils-scale/mock');
        return UtilsScale;
    });
```

### Documents
  - scale: make UI flexible on various screen sizes.
  - fontScale: make font size flexible on various screen sizes.
  - deviceInch: inch of device.
  - hasNotch: tells if the device is a has notch.
  - isAndroid: tells if the device is Android operating system.
  - isIOS: tells if the device is IOS operating system.
  - isSmallDevice: tells the device has a screen size smaller than 4.8 inches.
  - isTablet: tells if the device is a tablet.
  - width: screen width.
  - height: screen height. 
### Demo

![](https://github.com/hoaphantn7604/file-upload/blob/master/document/scale/demo.png)

### Usage
```javascript

import React from 'react';
import {SafeAreaView, ScrollView, StyleSheet, Text, View} from 'react-native';
import {
  fontScale, 
  scale,
  deviceInch, 
  hasNotch, 
  isAndroid, 
  isIOS, 
  isSmallDevice, 
  isTablet, 
  width,
  height,  
} from 'react-native-utils-scale';

const App = () => {
  return (
    <ScrollView>
      <SafeAreaView style={styles.container}>
        <Text style={styles.fontScale}>Device width: {width}</Text>
        <Text style={styles.fontScale}>Device height: {height}</Text>
        <Text style={styles.fontScale}>Device inch: {deviceInch}</Text>
        <Text style={styles.fontScale}>
          isAndroid: {isAndroid.toString()}
        </Text>
        <Text style={styles.fontScale}>isIOS: {isIOS.toString()}</Text>
        <Text style={styles.fontScale}>isTablet: {isTablet.toString()}</Text>
        <Text style={styles.fontScale}>hasNotch: {hasNotch.toString()}</Text>
        <Text style={styles.fontScale}>
          isSmallDevice: {isSmallDevice.toString()}
        </Text>

        <View style={[styles.box, styles.scale]}>
          <Text style={[styles.color, {fontSize: fontScale(14)}]}>150x150</Text>
          <Text style={[styles.color, {fontSize: fontScale(14)}]}>
            Scale: {scale(150)}x{scale(150)}
          </Text>
        </View>
      </SafeAreaView>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  fontScale: {
    fontSize: fontScale(16),
  },
  box: {
    width: 150,
    height: 150,
    backgroundColor: 'black',
    alignItems: 'center',
    justifyContent: 'center',
    margin: 16,
  },
  scale: {
    width: scale(150),
    height: scale(150),
  },
  color: {
    color: 'white',
  },
});

export default App;
```

### Suggested Packages
- [react-native-element-dropdown](https://www.npmjs.com/package/react-native-element-dropdown) A react-native dropdown component easy to customize for both iOS and Android.
- [react-native-element-image](https://www.npmjs.com/package/react-native-element-image) Automatically calculate width or height based on input Image component for React Native.
- [react-native-element-timer](https://www.npmjs.com/package/react-native-element-timer) React Native Timer Countdown.
- [react-native-vertical-swipe-view](https://www.npmjs.com/package/react-native-vertical-swipe-view) React Native Vertical Swipe View.
- [react-native-checkbox-tree](https://www.npmjs.com/package/react-native-checkbox-tree) A simple and elegant checkbox tree for React Native.
- [react-native-curved-bottom-bar](https://www.npmjs.com/package/react-native-curved-bottom-bar) A high performance, beautiful and fully customizable curved bottom navigation bar for React Native.
- [react-native-webrtc-simple](https://www.npmjs.com/package/react-native-webrtc-simple) A simple and easy to use module that help in making video call for React Native.