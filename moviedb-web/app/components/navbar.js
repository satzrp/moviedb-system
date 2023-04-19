export const NavBar = () => {
  return (
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <a class="navbar-brand me-2" href="/">
          <i class="bi bi-film logo"></i> <span class="logo-text ms-2">Movie Database</span>
        </a>

        <button
          class="navbar-toggler"
          type="button"
          data-mdb-toggle="collapse"
          data-mdb-target="#navbarButtonsExample"
          aria-controls="navbarButtonsExample"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <i class="fas fa-bars"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarButtonsExample">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>
          <div class="d-flex align-items-center">
            <a href="/login" class="btn btn-primary px-3 me-2">
              Login
            </a>
            <a href="/signup" class="btn btn-primary me-3">
              Sign up
            </a>
          </div>
        </div>
      </div>
    </nav>
  );
};
