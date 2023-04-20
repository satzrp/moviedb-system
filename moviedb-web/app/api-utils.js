const httpGet = async (url) => {
  const response = await fetch(url, {
    next: {
      revalidate: 60,
    },
  });
  const data = await response.json();
  return data;
};

const httpPost = async (url, payload) => {
  try {
    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(payload),
    });
    return response;
  } catch (error) {
    console.error("Error: ", error);
  }
};

export { httpGet, httpPost };
