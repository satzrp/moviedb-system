import Link from "next/link";
import AuthButtons from "./auth-buttons";

const NavBar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <Link className="navbar-brand me-2" href="/">
          <i className="bi bi-film logo"></i> <span className="logo-text ms-2">Movie Database</span>
        </Link>
        <div className="collapse navbar-collapse" id="navbarButtonsExample">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0"></ul>
          <AuthButtons />
        </div>
      </div>
    </nav>
  );
};

export default NavBar;
