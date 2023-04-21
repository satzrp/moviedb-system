"use client";
import Link from "next/link";
import { useAuthContext } from "../context/auth";
import { usePathname } from "next/navigation";

const AuthButtons = () => {
  const { user, setUser } = useAuthContext();
  const handleLogout = () => {
    localStorage.removeItem("user");
    setUser(null);
  };
  const currentPath = usePathname();
  return !!user ? (
    <div className="d-flex align-items-center">
      <span className="user-text">Logged in as: {user.email}</span>
      <button className="btn btn-primary px-3 me-2" onClick={handleLogout}>
        Logout
      </button>
    </div>
  ) : (
    <div className="d-flex align-items-center">
      <Link href={`/login?redirect=${currentPath}`} className="btn btn-primary px-3 me-2">
        Login
      </Link>
      <Link href={`/signup?redirect=${currentPath}`} className="btn btn-primary me-3">
        Sign up
      </Link>
    </div>
  );
};

export default AuthButtons;
