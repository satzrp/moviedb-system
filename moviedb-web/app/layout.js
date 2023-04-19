import "./globals.css";

export const metadata = {
  title: "Movie Database",
  description: "Movie Database - Demo Project",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body>{children}</body>
    </html>
  );
}
