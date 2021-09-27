import React, { useEffect, useState } from "react";
import { Button, Form } from "semantic-ui-react";
import axios from "axios";
import { useHistory } from 'react-router';

export default function Update() {
    let history = useHistory();
    const [name, setName] = useState("");
    const [interestRate, setInterestRate] = useState(0);
    const [maximumLoan, setMaximumLoan] = useState(0);
    const [minimumDownPayment, setMinimumDownPayment] = useState(0);
    const [loanTerm, setLoanTerm] = useState("");

    const [id, setId] = useState(null);
    useEffect(() => {
        setId(localStorage.getItem("id"));
        setName(localStorage.getItem("name"));
        setInterestRate(localStorage.getItem("interestRate"));
        setMaximumLoan(localStorage.getItem("maximumLoan"));
        setMinimumDownPayment(localStorage.getItem("minimumDownPayment"));
        setLoanTerm(localStorage.getItem("loanTerm"));
    }, []);

    const updateAPIData = () => {
        axios.put(`http://localhost:8080/api/v1/banks/${id}`, {
            id,
            name,
            interestRate,
            maximumLoan,
            minimumDownPayment,
            loanTerm,
        }).then(() => {
            history.push('/read')
        });
    };

    return (
        <div>
            <Form className="create-form">
                <Form.Field>
                    <label>Bank Name</label>
                    <input
                        placeholder="Bank Name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                </Form.Field>
                <Form.Field>
                    <label>Interest Rate (%)</label>
                    <input
                        placeholder="10"
                        value={interestRate}
                        onChange={(e) =>
                            setInterestRate(parseFloat(e.target.value))
                        }
                    />
                </Form.Field>
                <Form.Field>
                    <label>Maximum loan ($)</label>
                    <input
                        placeholder="40000"
                        value={maximumLoan}
                        onChange={(e) =>
                            setMaximumLoan(parseFloat(e.target.value))
                        }
                    />
                </Form.Field>
                <Form.Field>
                    <label>Minimum down payment (%)</label>
                    <input
                        placeholder="10"
                        value={minimumDownPayment}
                        onChange={(e) =>
                            setMinimumDownPayment(parseFloat(e.target.value))
                        }
                    />
                </Form.Field>
                <Form.Field>
                    <label>Loan term (months)</label>
                    <input
                        placeholder="12"
                        value={loanTerm}
                        onChange={(e) => setLoanTerm(parseInt(e.target.value))}
                    />
                </Form.Field>
                <Button type="submit" onClick={updateAPIData}>Update</Button>
            </Form>
        </div>
    );
}
