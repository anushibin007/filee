import React from "react";
import { Descriptions } from "antd";

export default function SizeChart({ size = 0 }) {
  const items = [
    {
      key: "1",
      label: "KB",
      children: `${size / 1024}`,
    },
    {
      key: "2",
      label: "MB",
      children: `${size / (1024 * 1024)}`,
    },
    {
      key: "3",
      label: "GB",
      children: `${size / (1024 * 1024 * 1024)}`,
    },
  ];
  return <Descriptions  bordered items={items} />;
}
