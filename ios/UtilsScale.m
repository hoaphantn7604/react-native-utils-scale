#import "UtilsScale.h"

@implementation UtilsScale

RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport
{
    return @{ 
        @"checkTablet": @([self isTablet]),
        @"checkSmallDevice": @([self isSmallDevice]),
        @"deviceInch": @([self deviceInch]),
        @"checkhasNotch": @([self hasNotch]),
    };
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

RCT_EXPORT_METHOD(sampleMethod:(NSString *)stringArgument numberParameter:(nonnull NSNumber *)numberArgument callback:(RCTResponseSenderBlock)callback)
{
    // TODO: Implement some actually useful functionality
    callback(@[[NSString stringWithFormat: @"numberArgument: %@ stringArgument: %@", numberArgument, stringArgument]]);
}

- (BOOL) isTablet
{
    // TODO: Implement some actually useful functionality
    if ( UI_USER_INTERFACE_IDIOM() == UIUserInterfaceIdiomPad )
    {
        return YES; /* Device is iPad */
    }else{
        return NO;
    }
    
}

- (BOOL) isSmallDevice
{
    float diagonal = [self deviceInch];

    if(diagonal < 4.8){
        return YES;
    }else{
        return NO;
    }
}

- (float) deviceInch
{
    float scale = [[UIScreen mainScreen] scale];

    float ppi = scale * ((UI_USER_INTERFACE_IDIOM() == UIUserInterfaceIdiomPad) ? 132 : 163);

    float width = ([[UIScreen mainScreen] bounds].size.width * scale);
    float height = ([[UIScreen mainScreen] bounds].size.height * scale);

    float horizontal = width / ppi, vertical = height / ppi;

    float diagonal = sqrt(pow(horizontal, 2) + pow(vertical, 2));

    return diagonal;
}

- (BOOL) hasNotch
{
    if (@available(iOS 13.0, *)) {
        if([self keyWindow].safeAreaInsets.top > 20.0){
            return YES;
        }else {
            return NO;
        }
       
    }else{
        if (@available(iOS 11.0, *)) {
            if([[[UIApplication sharedApplication] delegate] window].safeAreaInsets.top > 20.0){
                return YES;
            }else {
                return NO;
            }
        } else {
            // Fallback on earlier versions
            return NO;
        }
       
    }
}

- (UIWindow*)keyWindow {
    UIWindow        *foundWindow = nil;
    NSArray         *windows = [[UIApplication sharedApplication]windows];
    for (UIWindow   *window in windows) {
        if (window.isKeyWindow) {
            foundWindow = window;
            break;
        }
    }
    return foundWindow;
}

@end
