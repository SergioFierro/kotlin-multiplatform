//
//  AccessTokenViewModel.swift
//  iosApp
//
//  Created by Sergio Fierro on 11/18/20.
//  Copyright © 2020 orgName. All rights reserved.
//

import Foundation
import shared

class AccessTokenViewModel: ObservableObject {
    
    private let accessTokenRepository: AccessTokenRepository
    private let localStorage: LocalStorage
    @Published var url: String {
        didSet {
            localStorage.accessTokenURL = url
        }
    }
    @Published var identity: String = String()
    @Published var accessTokenResponse: AccessTokenResponse? = nil
    
    init(accessTokenRepository: AccessTokenRepository = AccessTokenRepository(), localStorage: LocalStorage = LocalStorage()) {
        self.accessTokenRepository = accessTokenRepository
        self.localStorage = localStorage
        url = self.localStorage.accessTokenURL
    }
    
    func getAccessToken() {
        accessTokenRepository.fetchAccessToken(url: url, identity: identity) { response, error in
            guard let response = response, error == nil else {
                print(error)
                return
            }
            self.accessTokenResponse = response
        }
    }
}
