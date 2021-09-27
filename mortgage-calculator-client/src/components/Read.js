import React, { useEffect, useState } from "react";
import { Button, Table } from "semantic-ui-react";
import axios from "axios";
import { Link } from "react-router-dom";

export default function Read() {
    const [APIData, setAPIData] = useState([]);
    useEffect(() => {
        axios.get(`http://localhost:8080/api/v1/banks`).then((response) => {
            setAPIData(response.data);
        });
    }, []);

    const setData = (data) => {
        let {
            id,
            name,
            interestRate,
            maximumLoan,
            minimumDownPayment,
            loanTerm,
        } = data;
        localStorage.setItem("id", id);
        localStorage.setItem("name", name);
        localStorage.setItem("interestRate", interestRate);
        localStorage.setItem("maximumLoan", maximumLoan);
        localStorage.setItem("minimumDownPayment", minimumDownPayment);
        localStorage.setItem("loanTerm", loanTerm);
    };

    const onDelete = (id) => {
        axios.delete(`http://localhost:8080/api/v1/banks/${id}`)
        .then(() => {
            getData();
        })
    }

    const getData = () => {
        axios.get(`http://localhost:8080/api/v1/banks`)
            .then((getData) => {
                 setAPIData(getData.data);
             })
    }
    return (
        <div>
            <Table singleLine>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Id</Table.HeaderCell>
                        <Table.HeaderCell>Bank Name</Table.HeaderCell>
                        <Table.HeaderCell>Interest Rate (%)</Table.HeaderCell>
                        <Table.HeaderCell>Maximum loan ($)</Table.HeaderCell>
                        <Table.HeaderCell>
                            Minimum down payment (%)
                        </Table.HeaderCell>
                        <Table.HeaderCell>Loan term (months)</Table.HeaderCell>
                        <Table.HeaderCell>Update</Table.HeaderCell>
                        <Table.HeaderCell>Delete</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {APIData.map((data) => {
                        return (
                            <Table.Row>
                                <Table.Cell>{data.id}</Table.Cell>
                                <Table.Cell>{data.name}</Table.Cell>
                                <Table.Cell>{data.interestRate}</Table.Cell>
                                <Table.Cell>{data.maximumLoan}</Table.Cell>
                                <Table.Cell>
                                    {data.minimumDownPayment}
                                </Table.Cell>
                                <Table.Cell>{data.loanTerm}</Table.Cell>
                                <Table.Cell>
                                    <Link to="/update">
                                        <Button onClick={() => setData(data)}>
                                            Update
                                        </Button>
                                    </Link>
                                </Table.Cell>
                                <Table.Cell>
                                    <Button onClick={() => onDelete(data.id)}>
                                        Delete
                                    </Button>
                                </Table.Cell>
                            </Table.Row>
                        );
                    })}
                </Table.Body>
            </Table>
        </div>
    );
}
