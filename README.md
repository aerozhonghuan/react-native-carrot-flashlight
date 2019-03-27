
# react-native-carrot-flashlight

## Getting started

`$ npm install react-native-carrot-flashlight --save`

### Mostly automatic installation

`$ react-native link react-native-carrot-flashlight`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-carrot-flashlight` and add `RNCarrotFlashlight.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNCarrotFlashlight.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.aero.flashlight.RNCarrotFlashlightPackage;` to the imports at the top of the file
  - Add `new RNCarrotFlashlightPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-carrot-flashlight'
  	project(':react-native-carrot-flashlight').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-carrot-flashlight/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-carrot-flashlight')
  	```
## Methods

| Method  | Params  | Description |
| :------------ |:---------------:| :---------------:|
| setFlashlight | (isOpen, callback(success, errMsg)) | Turn the flashlight on or off |


## Usage
```javascript
import CarrotFlashlight from 'react-native-carrot-flashlight';

constructor (props) {
    super(props)
    this.state = {
      flashlightPress:false,//是否打开手电筒
    }
  }

// TODO: What to do with the module?
  onPress = ()=>{
    CarrotFlashlight.setFlashlight((!this.state.flashlightPress),(success,msg) => {
      if(success){
          this.setState({
            flashlightPress:!this.state.flashlightPress
          })
        }else{
          alert(msg);
        }     
    })
  }
```
  
