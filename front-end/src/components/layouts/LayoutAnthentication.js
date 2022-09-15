import React from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { withErrorBoundary } from "react-error-boundary";
import ErrorComponent from "../components/common/ErrorComponent";

const LayoutAnthentication = (props) => {
  const { children, heading } = props;
  return (
    <div className="relative w-full min-h-screen p-10 bg-lite dark:bg-darkbg isolate">
      <img
        src="/logoSignInUp.png"
        alt="bg"
        className=" hidden lg:block absolute bottom-0 left-0 right-0 pointer-events-none z-[-1]"
      />
      <Link to={"/"} className="flex items-center justify-center mb-5 lg:mb-5">
        <img srcSet="/logo192.png 2x" alt="crowfunding-app" />
      </Link>
      <div className="w-full max-w-[556px] bg-lightBlue dark:bg-darkSecondary rounded-xl px-5 py-8 lg:px-16 lg:py-12  mx-auto">
        <h1 className="mb-1 text-lg font-semibold text-center lg:text-xl lg:mb-3 text-text1 dark:text-white">
          {heading}
        </h1>
        {children}
      </div>
    </div>
  );
};

LayoutAnthentication.propTypes = {
  heading: PropTypes.string,
  children: PropTypes.node,
};
export default withErrorBoundary(LayoutAnthentication, {
  FallbackComponent: ErrorComponent,
});
