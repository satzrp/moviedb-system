"use client";
import { httpPost } from "@/app/api-utils";
import { API_URL } from "@/app/config";
import { useAuthContext } from "@/app/context/auth";
import Image from "next/image";
import { useState } from "react";

const AddReview = ({ movieId }) => {
  const { user } = useAuthContext();
  const [reviewContent, setReviewContent] = useState();
  const handleAddReview = async (e) => {
    e.preventDefault();
    const response = await httpPost(`${API_URL}/movies/${movieId}/reviews`, { reviewContent }, user.token);
    if (response && response.status === 201) {
      setReviewContent("");
    }
    // TODO: handle error scenario
  };
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
            <form onSubmit={handleAddReview}>
              <label className="form-label fw-light" htmlFor="reviewContent">
                What is your view about the movie?
              </label>
              <div className="form-outline">
                <textarea
                  required
                  className="form-control"
                  name="reviewContent"
                  id="reviewContent"
                  rows="4"
                  maxLength="300"
                  value={reviewContent}
                  onChange={(e) => setReviewContent(e.target.value)}
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
