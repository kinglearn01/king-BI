import {UploadOutlined,} from '@ant-design/icons';
import {Button, Card, Col, Form, Input, message, Row, Select, Space, Spin} from 'antd';
import React, {useState} from 'react';
import TextArea from "antd/es/input/TextArea";
import Upload from "antd/es/upload/Upload";
import {getChartByAiAsyncUsingPost, getChartByAiUsingPost} from "@/services/kingBI/chartController";
import ReactECharts from 'echarts-for-react';
import {AvatarName} from "@/components";

const AsyncAddChart: React.FC = () => {
 const [chart,setChart] =useState<API.BiResponse>();
 const [submitting,setSubmitting] =useState<boolean>(false);
  const [option,setOption] =useState<any>();
  const onFinish =async (values: any) => {
    if (submitting){
      return;
    }
    setChart(undefined);
    setOption(undefined);
    const params = {
      ...values,
      file:undefined
    }
    const res = await getChartByAiAsyncUsingPost(params,{},values.file.file.originFileObj)
    if (!res.data){
      message.error("提交失败");
    }else {
      message.success("提交成功,请稍后在列表页查看");
    }


  };
  return (
    <div className="add_chart">
      <Row  gutter={24}>
        <Col span={12}>
          <Card  title={"智能分析"}>
            <Form
              layout={"horizontal"}
              labelWrap
              name="addchart"
              onFinish={onFinish}
              initialValues={{}}
              style={{maxWidth: 600}}
            >
              <Form.Item name="goal" label="分析目标" rules={[{required: true, message: '请输入分析目标'}]}>
                <TextArea placeholder="请输入你的分析需求"/>
              </Form.Item>
              <Form.Item name="name" label="图表名称">
                <Input placeholder="请输入你的图表名称"/>
              </Form.Item>
              <Form.Item
                name="chartType"
                label="图表类型"
              >
                <Select placeholder="Please select a country"
                        options={[
                          {value: '折线图', label: '折线图'},
                          {value: '柱状图', label: '柱状图'},
                          {value: '饼图', label: '饼图'},
                          {value: '雷达图', label: '雷达图'},
                          {value: '堆叠图', label: '堆叠图'},
                          {value: '散点图', label: '散点图'},
                        ]}
                />
              </Form.Item>
              <Form.Item
                name="file"
                label="原始数据"
              >
                <Upload name="file" maxCount={1}>
                  <Button icon={<UploadOutlined/>}>上传CSV文件</Button>
                </Upload>
              </Form.Item>
              <Form.Item wrapperCol={{span: 12, offset: 6}}>
                <Space>
                  <Button type="primary" htmlType="submit" >
                    提交
                  </Button>
                  <Button htmlType="reset">重置</Button>
                </Space>
              </Form.Item>
            </Form>
          </Card>
        </Col>
      </Row>
    </div>
  );
};
export default AsyncAddChart;
