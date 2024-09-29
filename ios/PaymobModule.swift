import Foundation
import PaymobSDK

@objc(PaymobModule)
class PaymobModule: NSObject {

    @objc
    func initializePaymob(_ publicKey: String, clientSecret: String, resolve: RCTPromiseResolveBlock, reject: RCTPromiseRejectBlock) {
        let paymob = PaymobSDK()
        paymob.delegate = self
        
        do {
            try paymob.presentPayVC(VC: UIApplication.shared.delegate!.window!!.rootViewController!,
                                    PublicKey: publicKey,
                                    ClientSecret: clientSecret,
                                    SavedBankCards: [])
            resolve(true)
        } catch let error {
            reject("PAYMOB_ERROR", "Error initializing Paymob", error)
        }
    }
}
