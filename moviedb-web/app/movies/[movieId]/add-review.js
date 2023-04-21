"use client";
import { useAuthContext } from "@/app/context/auth";
import Image from "next/image";

// TODO: Post review to backend and persist in the database
const AddReview = () => {
  const { user } = useAuthContext();
  return !!user ? (
    <div className="card">
      <div className="card-body p-4">
        <div className="d-flex flex-start w-100">
          <Image
            className="rounded-circle shadow-1-strong me-3"
            src="/avatar.png"
            alt="avatar"
            width="40"
            height="40"
          />
          <div className="w-100">
            <form>
              <label className="form-label fw-light" for="reviewContent">
                What is your view about the movie?
              </label>
              <div className="form-outline">
                <textarea
                  required
                  className="form-control"
                  name="reviewContent"
                  id="reviewContent"
                  rows="4"
                  maxlength="300"
                ></textarea>
              </div>
              <div className="d-flex justify-content-between mt-3">
                <button className="btn btn-primary">Post Review</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  ) : (
    <></>
  );
};

export default AddReview;
