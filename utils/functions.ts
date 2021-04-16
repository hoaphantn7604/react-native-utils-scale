import { NativeModules, Dimensions, Platform } from 'react-native';
import { devicesWithNotch } from './devicesWithNotch'

const { UtilsScale } = NativeModules;
const { checkTablet, checkSmallDevice, checkhasNotch, getModel, getBrand, deviceInch } = UtilsScale.getConstants();

const isTablet = () => {
    return checkTablet;
};

const getDeviceInch = () => {
    return deviceInch.toFixed(1);
}

const isSmallDevice = () => {
    return checkSmallDevice;
};


const isIphoneX = () => {
    if (Platform.OS === 'ios') {
        if (checkTablet) {
            return false;
        } else {
            return checkhasNotch;
        }
    } else {
        const model = getModel;
        const brand = getBrand;

        const notch = devicesWithNotch.findIndex(item => item.brand.toLowerCase() === brand.toLowerCase() && item.model.toLowerCase() === model.toLowerCase()) !== -1;
        return notch;
    }
}

const hasNotch = () => {
    return isIphoneX();
}

const isAndroid = () => {
    return Platform.OS === 'android';
};

const isIOS = () => {
    return Platform.OS === 'ios';
};


const dimensionsScale = {
    fontScale: (number: number = 1) => {
        const value = (deviceInch + (checkSmallDevice ? 2 : 3)) / 10;
        const scale = number * value.toFixed(1);
        return scale;
    },
    scale: (number: number = 1) => {
        const value = (deviceInch + (checkSmallDevice ? 3 : 4)) / 10;
        const scale = number * value.toFixed(1);
        return scale;
    },
    scaleH: (number: number = 1) => {
        const value = (deviceInch + (checkSmallDevice ? 3 : 4)) / 10;
        const scale = number * value.toFixed(1);
        return scale;
    },
    scaleW: (number: number = 1) => {
        const value = (deviceInch + (checkSmallDevice ? 3 : 4)) / 10;
        const scale = number * value.toFixed(1);
        return scale;
    },
    deviceWidth: () => {
        const { width } = Dimensions.get('screen');
        return width.toFixed(0);
    },
    deviceHeight: () => {
        const { height } = Dimensions.get('screen');
        return height.toFixed(0);
    },
};

export { dimensionsScale, isAndroid, isIOS, isTablet, isSmallDevice, isIphoneX, hasNotch, getDeviceInch }