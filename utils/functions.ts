import { NativeModules, Dimensions, Platform } from 'react-native';
import { devicesWithNotch } from './devicesWithNotch'

const { UtilsScale } = NativeModules;
const { checkTablet, checkSmallDevice, checkhasNotch, getModel, getBrand } = UtilsScale.getConstants();

const isTablet = () => {
    return checkTablet;
};

const isSmallDevice = () => {
    return checkSmallDevice;
};


const isIphoneX = () => {
    if (Platform.OS === 'ios') {
        if(checkTablet){
            return false;
        }else {
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
    fontScale:()=> {
        const { width, height } = Dimensions.get('screen');
        const DESIGN_WIDTH = width / (checkTablet ? 1.2 : checkSmallDevice ? 0.7 : 1);
        const DESIGN_HEIGHT = height / (checkTablet ? 1.2 : checkSmallDevice ? 0.7 : 1);
        const ratioW = width / DESIGN_WIDTH;
        const ratioH = height / DESIGN_HEIGHT;
        const value = Math.min(ratioW, ratioH);

        return value;
    },
    scale: () => {
        const { width, height } = Dimensions.get('screen');
        const DESIGN_WIDTH = width / (checkTablet ? 1.3 : checkSmallDevice ? 0.7 : 1);
        const DESIGN_HEIGHT = height / (checkTablet ? 1.3 : checkSmallDevice ? 0.7 : 1);
        const ratioW = width / DESIGN_WIDTH;
        const ratioH = height / DESIGN_HEIGHT;
        const value = Math.min(ratioW, ratioH);

        return value;
    },
    scaleH: () => {
        const { height } = Dimensions.get('screen');
        const DESIGN_HEIGHT = height / (checkTablet ? 1.3 : checkSmallDevice ? 0.7 : 1);
        const ratioH = height / DESIGN_HEIGHT;
        return ratioH;
    },
    scaleW: () => {
        const { width } = Dimensions.get('screen');
        const DESIGN_WIDTH = width / (checkTablet ? 1.3 : checkSmallDevice ? 0.7 : 1);
        const ratioW = width / DESIGN_WIDTH;
        return ratioW;
    },
    deviceWidth: () => {
        const { width } = Dimensions.get('screen');
        return width;
    },
    deviceHeight: () => {
        const { height } = Dimensions.get('screen');
        return height;
    },
};

export { dimensionsScale, isAndroid, isIOS, isTablet, isSmallDevice, isIphoneX, hasNotch}