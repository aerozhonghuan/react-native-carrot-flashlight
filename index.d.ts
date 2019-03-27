/*
 * @Description: react-native-carrot-flashlight,Solve the problem of launching a white screen in a React Native project
 * @Author: wanglh
 * @LastEditors: wanglh
 * @Date: 2018-05-29 14:55:15
 * @LastEditTime: 2019-03-27 15:50:59
 */

declare module "react-native-carrot-flashlight" {
    declare const CarrotFlashlight: {
        /**
         * @description: Turn the flashlight on or off
         * @param isOpen {boolean} true:on, false:off
         * @param callback {func}  isSucc: true or false, errMsg: error desc
         * @return: void
         */
        setFlashlight(isOpen:boolean,callback?:(isSucc:boolean,errMsg:string)=>void) : void;
    }
    export default CarrotFlashlight;
}
