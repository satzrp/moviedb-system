const Register = () => {
  return (
    <div className="container login-container">
      <div className="row">
        <div className="col-sm-9 col-md-7 col-lg-6 mx-auto">
          <h1 className="text-center p-3 mt-5">Signup to the Movie Database</h1>
          <div className="card border-0 shadow rounded-3 my-5">
            <div className="card-body p-4 p-sm-5">
              <h5 className="card-title text-center mb-5 fw-light fs-5">Sign Up</h5>
              <form method="POST" action="?/signup">
                <div className="form-floating mb-3">
                  <input
                    name="name"
                    type="text"
                    required
                    className="form-control"
                    id="floatingInputName"
                    placeholder="Your Name"
                  />
                  <label htmlFor="floatingInputName">Name</label>
                </div>
                <div className="form-floating mb-3">
                  <input
                    name="email"
                    type="email"
                    required
                    className="form-control"
                    id="floatingInput"
                    placeholder="name@example.com"
                  />
                  <label htmlFor="floatingInput">Email address</label>
                </div>
                <div className="form-floating mb-3">
                  <input
                    name="password"
                    type="password"
                    required
                    className="form-control"
                    id="floatingPassword"
                    placeholder="Password"
                  />
                  <label htmlFor="floatingPassword">Password</label>
                </div>
                <div className="d-grid">
                  <button className="btn btn-login text-uppercase fw-bold" type="submit">
                    Sign Up
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;
