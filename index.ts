import { Dimensions, Platform } from 'react-native';
import DeviceInfo from 'react-native-device-info';

const fontBaseXSmall = 12;
const fontBaseSmall = 15;
const fontBaseNormal = 17;
const fontBaseLarge = 20;
const fontBaseXLarge = 24;
const fontBaseXXLarge = 28;

export const isTablet = () => {
  return DeviceInfo.isTablet();
};

export const responsiveFontSize = (fontSize: number) => {
  const { width, height } = Dimensions.get('window');
  const DEVICE_WIDTH = height > width ? width : height;
  let divider = isTablet() ? 600 : 375;
  return Math.round((fontSize * DEVICE_WIDTH) / divider);
};

export const fontXSmall = responsiveFontSize(fontBaseXSmall);
export const fontSmall = responsiveFontSize(fontBaseSmall);
export const fontNormal = responsiveFontSize(fontBaseNormal);
export const fontLarge = responsiveFontSize(fontBaseLarge);
export const fontXLarge = responsiveFontSize(fontBaseXLarge);
export const fontXXLarge = responsiveFontSize(fontBaseXXLarge);

export const responsiveHeight = (height: number) => {
  if (!isTablet()) {
    return height;
  } else {
    return height + height * 0.25;
  }
};

export function isIphoneX() {
  return DeviceInfo.hasNotch();
}

export const dimensionsScale = {
  scale: () => {
    const { width, height } = Dimensions.get('window');
    const DESIGN_WIDTH = width / (isTablet() ? 1.2 : isTablet() ? 1.3 : 0.8);
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
  componentHight: () => {
    const { height } = Dimensions.get(isTablet() && Platform.OS === 'ios' ? 'screen' : 'window');
    const DESIGN_HEIGHT = height / (isTablet() ? 1.3 : 0.9);
    const ratioH = height / DESIGN_HEIGHT;
    return 40 * ratioH;
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
