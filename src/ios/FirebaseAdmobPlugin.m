#import <Cordova/CDVPlugin.h>
#import "FirebaseAdmobPlugin.h"
@import GoogleMobileAds;

@implementation FirebaseAdmobPlugin

- (void)addTestDevice:(CDVInvokedUrlCommand*)command
{
  CDVPluginResult* pluginResult = nil;

  pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];

  [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)getTestDevices:(CDVInvokedUrlCommand*)command
{
  CDVPluginResult* pluginResult = nil;

  pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];

  [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)requestInterstitial:(CDVInvokedUrlCommand*)command
{
  CDVPluginResult* pluginResult = nil;

  pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];

  [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)setInterstitialAdUnitId:(CDVInvokedUrlCommand*)command
{
  CDVPluginResult* pluginResult = nil;

  pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];

  [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)showInterstitial:(CDVInvokedUrlCommand*)command
{
  CDVPluginResult* pluginResult = nil;

  pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];

  [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
