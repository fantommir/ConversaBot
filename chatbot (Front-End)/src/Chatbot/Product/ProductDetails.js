import React, { useState, useEffect } from "react";
import axios from "axios";

const ProductDetails = ({ userData }) => {
  const [productData, setProductData] = useState(null);

  useEffect(() => {
    const fetchProductDetails = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/accounts/${userData}/products`
        );
        console.log("Product details response:", response.data);
        setProductData(response.data);
      } catch (error) {
        console.error("Error fetching product details:", error);
      }
    };

    fetchProductDetails();

    return () => {
      // Any cleanup code if needed
    };
  }, [userData]);

  return (
    <div>
      {productData ? (
        <div>
          {productData.map((product, index) => (
            <div key={index}>
              <p>Product {index + 1} Details:</p>
              <p>Product ID: {product.productId}</p>
              <p>Product Name: {product.productName}</p>
              <p>Product Price: {product.productPrice}</p>
              <br /> {/* Line break */}
            </div>
          ))}
        </div>
      ) : (
        <p>Loading product details...</p>
      )}
    </div>
  );
};

export default ProductDetails;
