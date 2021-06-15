import { useDetectDevice, useScale } from './toolkit';

const { 
    deviceInch, 
    hasNotch, 
    height, 
    isAndroid, 
    isIOS, 
    isSmallDevice, 
    isTablet, 
    width 
} = useDetectDevice;

const { fontScale, scale } = useScale;

export { 
    deviceInch, 
    hasNotch, 
    height, 
    isAndroid, 
    isIOS, 
    isSmallDevice, 
    isTablet, 
    width, 
    fontScale, 
    scale
};
