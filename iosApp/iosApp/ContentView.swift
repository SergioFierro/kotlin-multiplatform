import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    @ObservedObject var accessTokenViewModel = AccessTokenViewModel()
    
    var body: some View {
        VStack {
            Text(greet())
                .fontWeight(.heavy)
            TextField("AccessToken URL", text: $accessTokenViewModel.url)
                .padding(.all)
                .frame(width: 360.0)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            TextField("Identity", text: $accessTokenViewModel.identity)
                .padding(.all)
                .frame(width: 360.0)
                .textFieldStyle(RoundedBorderTextFieldStyle())
            Button("Generate Access Token") {
                self.accessTokenViewModel.getAccessToken()
            }
            .padding(.all)
            VStack {
                HStack {
                    Text("Token: ")
                        .padding(.trailing)
                    Spacer()
                    Text(accessTokenViewModel.accessTokenResponse?.token ?? "")
                        .lineLimit(3)
                        .frame(width: 270.0)
                }
                .padding(.all)
                HStack {
                    Text("Identity: ")
                        .padding(.trailing)
                    Spacer()
                    Text(accessTokenViewModel.accessTokenResponse?.identity ?? "")
                        .lineLimit(3)
                        .frame(width: 270.0)
                }
                .padding(.all)
                HStack {
                    Text("ServiceSid: ")
                        .padding(.trailing)
                    Spacer()
                    Text(accessTokenViewModel.accessTokenResponse?.serviceSid ?? "")
                        .lineLimit(3)
                        .frame(width: 270.0)
                }
                .padding(.all)
                Spacer()
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
