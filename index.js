
import { NativeModules } from 'react-native';

const { RNCarrotFlashlight } = NativeModules;

export default {
    setFlashlight() {
        return RNCarrotFlashlight.setFlashlight;
    },
};
