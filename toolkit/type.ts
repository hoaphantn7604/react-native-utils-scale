export interface UseScale {
    fontScale: (number: number) => number;
    scale:  (number: number) => number;
}

export interface UseDetectDevice {
    isTablet: boolean;
    isSmallDevice: boolean;
    isAndroid: boolean;
    isIOS: boolean;
    hasNotch: boolean;
    deviceInch: number;
    width: number;
    height: number;
}