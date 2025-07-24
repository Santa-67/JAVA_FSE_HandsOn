import React from "react";
import { shallow, mount } from "enzyme";
import CohortDetails from "./CohortDetails";
import { CohortsData } from "./Cohort";

describe("Cohort Details Component", () => {
  test("should create the component", () => {
    const cohort = { cohortCode: "C001", technology: "React" };
    const wrapper = shallow(<CohortDetails cohort={cohort} />);
    expect(wrapper.exists()).toBe(true);
  });

  test("should initialize the props", () => {
    const cohort = CohortsData[0];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    expect(wrapper.props().cohort).toEqual(cohort);
  });

  test("should display cohort code in h3", () => {
    const cohort = CohortsData[0];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    const h3 = wrapper.find("h3");
    expect(h3.text()).toContain(cohort.cohortCode);
  });

  test("should always render same html", () => {
    const cohort = CohortsData[0];
    const wrapper = mount(<CohortDetails cohort={cohort} />);
    expect(wrapper.html()).toMatchSnapshot();
  });
});