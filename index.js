
import { NativeModules } from 'react-native';

const { RNCarrotFlashlight } = NativeModules;

export default CarrotFlashlight {
    setFlashlight: function() {
        return RNCarrotFlashlight.setFlashlight;
    };
};
