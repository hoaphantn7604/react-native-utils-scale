# react-native-utils-scale

## Getting started

`$ yarn add react-native-utils-scale`

### IOS Setup

`$ cd ios && pod install && cd ../`

### Demo

![Alt text](./document/demo.png?raw=true "Demo")

## Usage
```javascript

import React, {useEffect} from 'react';
import {SafeAreaView, ScrollView, StyleSheet, Text, View} from 'react-native';
import {
  dimensionsScale,
  isAndroid,
  isIOS,
  hasNotch,
  isTablet,
  isSmallDevice
} from 'react-native-utils-scale';

const {scale, fontScale, deviceWidth, deviceHeight} = dimensionsScale;

const App = () => {
  useEffect(() => {}, []);

  return (
    <ScrollView>
      <SafeAreaView style={styles.container}>
        <Text style={styles.fontScale}>Device width: {deviceWidth()}</Text>
        <Text style={styles.fontScale}>Device height: {deviceHeight()}</Text>
        <View style={styles.box}>
          <Text style={[styles.color, {fontSize: 14}]}>150x150</Text>
          <Text style={[styles.color, {fontSize: 14}]}>Default</Text>
        </View>
        <View style={[styles.box, styles.scale]}>
          <Text style={[styles.color, {fontSize: 14 * fontScale()}]}>
            150x150
          </Text>
          <Text style={[styles.color, {fontSize: 14 * fontScale()}]}>
            Scale: {150 * scale()}x{150 * scale()}
          </Text>
        </View>

        <Text style={styles.fontScale}>
          isAndroid: {isAndroid().toString()}
        </Text>
        <Text style={styles.fontScale}>isIOS: {isIOS().toString()}</Text>
        <Text style={styles.fontScale}>hasNotch: {hasNotch().toString()}</Text>
        <Text style={styles.fontScale}>isTablet: {isTablet().toString()}</Text>
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
    fontSize: 16 * fontScale(),
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
    width: 150 * scale(),
    height: 150 * scale(),
  },
  color: {
    color: 'white',
  },
});

export default App;
```
