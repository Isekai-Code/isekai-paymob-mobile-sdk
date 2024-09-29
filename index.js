import { NativeModules } from 'react-native';
const { PaymobModule } = NativeModules;

const initializePaymob = (publicKey, clientSecret) => {
  return PaymobModule.initializePaymob(publicKey, clientSecret);
};

export { initializePaymob };
