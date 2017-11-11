#import <Cordova/CDVPlugin.h>
#import "FirebaseAdmobPlugin.h"
@import GoogleMobileAds;

@implementation FirebaseAdmobPlugin

- (void)showAd:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;

    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:
                    [[FIRInstanceID instanceID] token]];

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
