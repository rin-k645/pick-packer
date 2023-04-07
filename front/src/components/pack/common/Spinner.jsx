import styled from "styled-components";

const Spinner = () => {
  return (
    <LayerPopup>
      <div className="spinner"></div>
    </LayerPopup>
  );
};

export default Spinner;

const LayerPopup = styled.div`
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.4);
  z-index: 1000;
  justify-content: center;
  align-items: center;
  margin: -30px 0 0 -30px;

  .spinner {
    position: absolute;
    top: 50%;
    left: 50%;
    border: 8px solid #f3f3f3; /* Light grey */
    border-top: 8px solid #3498db; /* Blue */
    border-radius: 50%;
    width: 60px;
    height: 60px;
    animation: spinner 2s linear infinite;
  }
  @keyframes spinner {
    0% {
      transform: rotate(0deg);
    }
    100% {
      transform: rotate(360deg);
    }
  }
`;
