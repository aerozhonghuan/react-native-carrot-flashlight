
#import "RNCarrotFlashlight.h"
#import <AVFoundation/AVFoundation.h>
@interface RNCarrotFlashlight ()
@property (nonatomic,assign) BOOL lightOn;//手电筒状态，true:开启，false:关闭
@end

@implementation RNCarrotFlashlight

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

/**
 操作手电筒方法
 @param isOpen 控制手电筒开关，true:打开，false：关闭
 @param 操作结果的回调callback:回调
 */
RCT_EXPORT_METHOD(setFlashlight:(BOOL)isOpen resolver:(RCTResponseSenderBlock)callback){
    NSString *errorMsg= @"无错误！";
    BOOL isSucc = YES;
    _lightOn = isOpen;
    Class captureDeviceClass = NSClassFromString(@"AVCaptureDevice");
    if(captureDeviceClass !=nil) {
        AVCaptureDevice*device = [AVCaptureDevice defaultDeviceWithMediaType:AVMediaTypeVideo];
        if([device hasTorch]) { // 判断是否有手电筒
            // 请求独占访问硬件设备
            [device lockForConfiguration:nil];
            if(_lightOn) {
                [device setTorchMode:AVCaptureTorchModeOn];//手电筒开
            }else{
                [device setTorchMode:AVCaptureTorchModeOff]; // 手电筒关
            }
            // 请求解除独占访问硬件设备
            [device unlockForConfiguration];
        }else{
            isSucc = NO;
            errorMsg = @"手电筒不可用！";
        }
    }else{
        isSucc = NO;
        errorMsg = @"手电筒不可用！";
    }
    //准备回调回去的数据
    callback(@[[[NSNumber alloc]initWithBool:isSucc],errorMsg]);
}
@end

