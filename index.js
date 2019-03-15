import { NativeModules } from 'react-native';

const { RNCarrotFlashlight } = NativeModules;

export default {
    setFlashlight(isOpen, callback) {
        return RNCarrotFlashlight.setFlashlight(isOpen,callback);
    },
};
