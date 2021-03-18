import { Dimensions, Platform } from 'react-native';
import DeviceInfo from 'react-native-device-info';

export const isTablet = () => {
  return DeviceInfo.isTablet();
};

export function isIphoneX() {
  return DeviceInfo.hasNotch();
}

export const isAndroid = () => {
  return Platform.OS === 'android';
};

export const dimensionsScale = {
  scale: () => {
    const { width, height } = Dimensions.get('window');
    const DESIGN_WIDTH = width / (isTablet() ? 1.2 : 0.8);
    const DESIGN_HEIGHT = height / 1.1;
    const ratioW = width / DESIGN_WIDTH;
    const ratioH = height / DESIGN_HEIGHT;
    const value = Math.min(ratioW, ratioH);

    return value;
  },
  scaleH: () => {
    const { height } = Dimensions.get('window');
    const DESIGN_HEIGHT = height / (isTablet() ? 1.3 : 1);
    const ratioH = height / DESIGN_HEIGHT;
    return ratioH;
  },
  scaleW: () => {
    const { width } = Dimensions.get('window');
    const DESIGN_WIDTH = width / (isTablet() ? 1.3 : 1);
    const ratioW = width / DESIGN_WIDTH;
    return ratioW;
  },
  deviceWidth: () => {
    const { width } = Dimensions.get('window');
    return width;
  },
  deviceHeight: () => {
    const { height } = Dimensions.get('window');
    return height;
  },
};
