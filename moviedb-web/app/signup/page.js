"use client";

import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import { httpPost } from "../api-utils";
import { API_URL } from "../config";
import { useAuthContext } from "../context/auth";

const Register = () => {
  const router = useRouter();
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const { user, setUser } = useAuthContext();

  const handleSignup = async (e) => {
    e.preventDefault();
    const response = await httpPost(`${API_URL}/users/register`, { email, password, name });
    const data = await response.json();
    if (response.status === 403 && data.status === "FAIL") {
      setError(data.message);
    } else {
      localStorage.setItem("user", JSON.stringify(data.payload));
      setUser(data.payload);
      router.push("/");
    }
  };

  useEffect(() => {
    if (!!user) {
      router.push("/");
    }
  }, [user, router]);

  return (
    <div className="container login-container">
      <div className="row">
        <div className="col-sm-9 col-md-7 col-lg-6 mx-auto">
          <h1 className="text-center p-3 mt-5">Signup to the Movie Database</h1>
          <div className="card border-0 shadow rounded-3 my-5">
            <div className="card-body p-4 p-sm-5">
              <h5 className="card-title text-center mb-5 fw-light fs-5">Sign Up</h5>
              <form onSubmit={handleSignup}>
                {!!error && (
                  <div class="fixed-top alert alert-danger alert-dismissible fs-3 text-center fade show" role="alert">
                    {error}
                    <button type="button" class="btn-close fs-5" data-bs-dismiss="alert" aria-label="Close"></button>
                  </div>
                )}
                <div className="form-floating mb-3">
                  <input
                    name="name"
                    type="text"
                    required
                    className="form-control"
                    id="floatingInputName"
                    placeholder="Your Name"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
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
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
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
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
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
