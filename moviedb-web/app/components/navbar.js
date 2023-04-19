export const NavBar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <a className="navbar-brand me-2" href="/">
          <i className="bi bi-film logo"></i> <span className="logo-text ms-2">Movie Database</span>
        </a>

        <button
          className="navbar-toggler"
          type="button"
          data-mdb-toggle="collapse"
          data-mdb-target="#navbarButtonsExample"
          aria-controls="navbarButtonsExample"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <i className="fas fa-bars"></i>
        </button>

        <div className="collapse navbar-collapse" id="navbarButtonsExample">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0"></ul>
          <div className="d-flex align-items-center">
            <a href="/login" className="btn btn-primary px-3 me-2">
              Login
            </a>
            <a href="/signup" className="btn btn-primary me-3">
              Sign up
            </a>
          </div>
        </div>
      </div>
    </nav>
  );
};
