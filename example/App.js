/* eslint-disable react-native/no-inline-styles */
import React from 'react';
import {SafeAreaView, ScrollView, StyleSheet, Text, View} from 'react-native';
import {
  dimensionsScale,
  isAndroid,
  isIOS,
  hasNotch,
  isTablet,
  isSmallDevice,
  getDeviceInch,
} from 'react-native-utils-scale';

const {scale, fontScale, deviceWidth, deviceHeight} = dimensionsScale;

const App = () => {
  return (
    <ScrollView>
      <SafeAreaView style={styles.container}>
        <Text style={styles.fontScale}>Device width: {deviceWidth()}</Text>
        <Text style={styles.fontScale}>Device height: {deviceHeight()}</Text>
        <Text style={styles.fontScale}>Device inch: {getDeviceInch()}</Text>
        <Text style={styles.fontScale}>
          isAndroid: {isAndroid().toString()}
        </Text>
        <Text style={styles.fontScale}>isIOS: {isIOS().toString()}</Text>
        <Text style={styles.fontScale}>hasNotch: {hasNotch().toString()}</Text>
        <Text style={styles.fontScale}>isTablet: {isTablet().toString()}</Text>
        <Text style={styles.fontScale}>
          isSmallDevice: {isSmallDevice().toString()}
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
