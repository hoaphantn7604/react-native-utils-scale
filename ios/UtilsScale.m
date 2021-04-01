#import "UtilsScale.h"

@implementation UtilsScale

RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport
{
    return @{ 
        @"checkTablet": @([self isTablet]),
        @"checkhasNotch": @([self hasNotch]),
    };
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
