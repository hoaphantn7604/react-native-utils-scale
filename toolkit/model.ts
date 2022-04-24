export interface IUseScale {
  fontScale: (number: number) => number;
  scale: (number: number) => number;
}

export interface IUseDetectDevice {
  isTablet: boolean;
  isSmallDevice: boolean;
  isAndroid: boolean;
  isIOS: boolean;
  hasNotch: boolean;
  deviceInch: number;
  width: number;
  height: number;
}