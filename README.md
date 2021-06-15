# react-native-utils-scale
Makes the UI more perfect on many screen sizes.
## Getting started

```js 
  yarn add react-native-utils-scale
```
or

```js
  npm i react-native-utils-scale
```

### Start IOS

`$ cd ios && pod install`

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

![Alt text](./document/demo.png?raw=true "Demo")

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
