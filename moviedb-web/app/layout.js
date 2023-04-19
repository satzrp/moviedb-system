import { NavBar } from "./components/navbar";
import { Footer } from "./components/footer";
import "./globals.css";

export const metadata = {
  title: "Movie Database",
  description: "Movie Database - Demo Project",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>
        <NavBar />
        {children}
        <Footer />
      </body>
    </html>
  );
}
