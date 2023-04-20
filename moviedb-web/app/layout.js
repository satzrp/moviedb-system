import Script from "next/script";
import { AuthContextProvider } from "./context/auth";
import NavBar from "./components/navbar";
import Footer from "./components/footer";
import "./globals.css";

export const metadata = {
  title: "Movie Database",
  description: "Movie Database - Demo Project",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <AuthContextProvider>
          <NavBar />
          <main>{children}</main>
          <Footer />
        </AuthContextProvider>
        <Script
          src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
          crossorigin="anonymous"
          defer
        />
      </body>
    </html>
  );
}
