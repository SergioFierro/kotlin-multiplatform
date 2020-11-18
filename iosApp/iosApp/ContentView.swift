import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    @ObservedObject var accessTokenViewModel = AccessTokenViewModel()
    
    var body: some View {
        ZStack(alignment: .top) {
            HStack {
                Text(greet())
                    .fontWeight(.light)
                    .multilineTextAlignment(.center)
                    .frame(minWidth: 0, maxWidth: .infinity, minHeight: 100)
                    .font(.body)
            }
            .frame(minWidth: 0, maxHeight: 400, alignment: .topLeading)
            VStack(spacing: 0) {
                
                    // 2.
                TextField(" Enter some text", text: $accessTokenViewModel.url)
                                    .border(Color.black)
                
            }
            .foregroundColor(Color.black.opacity(0.7))
            .padding()
            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .leading)
            .offset(x: 0, y: 0)
            .font(.title)

        }
        .frame(minWidth: 0, maxWidth: .infinity, minHeight: 0, maxHeight: .infinity, alignment: .leading)
        .background(Color.orange.opacity(0.2))
        .edgesIgnoringSafeArea(.all)

    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}


//var body: some View {
//    ZStack(alignment: .top) {
//        VStack(alignment: .center){
//            Text(greet())
//                .multilineTextAlignment(.center)
//            Divider()
//            TextField("Enter url", text: $username)
//                .padding(.horizontal, 25.0)
//        }
//    }
//}
