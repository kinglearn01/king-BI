import React, {useEffect, useState} from 'react';
import {listMyChartByPageUsingPost} from "@/services/kingBI/chartController";
import {Avatar, Card, List, message, Result} from "antd";
import ReactECharts from "echarts-for-react";
import Search from "antd/es/input/Search";
import {useModel} from "@@/exports";

const MyChart: React.FC = () => {
  const initSearchParams = {
    pageSize:4,
    current:1,
    sortField: 'createTime',
    sortOrder: 'desc',
  }
  const [searchParams,setSearchParams]=useState<API.ChartQueryRequest>({...initSearchParams});
  const [chartList,setChartList]=useState<API.Chart[]>();
  const [total,setTotal]=useState<number>(0);
  const { initialState } = useModel('@@initialState');
  const { currentUser } = initialState ?? {};

  const loadData = async ()=>{
    try {
      const res = await listMyChartByPageUsingPost(searchParams);
      if (res.data){
          setChartList(res?.data.records ?? []);
          setTotal(res?.data?.total ?? 0);
      }else {
        message.error("获取图表失败");
      }
    } catch (e:any) {
      message.error("获取图表异常"+e.message);
    }
  }
  useEffect(()=>{
    loadData()
  },[searchParams])
  return (
    <div className={"my_chart"}>
      <div className="margin-16">
        <Search placeholder="请输入图表名称" enterButton onSearch={(value : string ) => {
          //设置搜索条件
        setSearchParams({
          ...initSearchParams,
          name: value,
        })
        }}/>
        </div>
      <List
        grid={{
          gutter:16,
          xs:1,
          sm:1,
          md:1,
          lg:2,
          xl:2,
          xxl:2
        }}
        pagination={{
          onChange: (page,pageSize) => {
            setSearchParams({
              ...searchParams,
              current:page,
              pageSize:pageSize,
            })
          },
          current:  searchParams.current,
          pageSize: searchParams.pageSize,
          total:total,
        }}
        dataSource={chartList}
        renderItem={(item) => (
          <List.Item
            key={item.id}
          >
            <Card >
            <List.Item.Meta
              avatar={<Avatar src={currentUser&&currentUser.userAvatar}/>}
              title={item.name}
              description={'图表类型:' + item.chartType}
            />
              <>
              {
                item.status==='waiting'&& <>
                  <Result status={"warning"} title={"图表待生成中"} subTitle={item.execMessage ?? '当前图表生成队列繁忙，请耐心等候'}/>
                </>
              }
              {
                  item.status==='running'&& <>
                    <Result status={"info"} title={"图表生成中"} subTitle={item.execMessage}/>
                  </>
              }
              {
                item.status==='succeed' &&
                <>
                  <p> {item.goal}</p>
                  <div>
                    <ReactECharts option={item.genChart && JSON.parse(item.genChart ?? '')}/>
                  </div>
                  <p> {item.genResult}</p>
                </>
              }
              { item.status==='failed' &&
                <Result status={"error"} title={"图表生成失败"} subTitle={item.execMessage}/>
              }
              </>
            </Card>
          </List.Item>
        )}
      />
    </div>
  );
};
export default MyChart;
