import React, { useState } from "react";
import { Button, Form } from "semantic-ui-react";
import axios from "axios";
import { useHistory } from "react-router";

function Create() {
    let history = useHistory();
    const [name, setName] = useState("");
    const [interestRate, setInterestRate] = useState(0);
    const [maximumLoan, setMaximumLoan] = useState(0);
    const [minimumDownPayment, setMinimumDownPayment] = useState(0);
    const [loanTerm, setLoanTerm] = useState("");

    const postData = () => {
        axios
            .post(`http://localhost:8080/api/v1/banks`, {
                name,
                interestRate,
                maximumLoan,
                minimumDownPayment,
                loanTerm,
            })
            .then(() => {
                history.push("/read");
            });
    };

    return (
        <Form className="create-form">
            <Form.Field>
                <label>Bank Name</label>
                <input
                    placeholder="Bank Name"
                    onChange={(e) => setName(e.target.value)}
                />
            </Form.Field>
            <Form.Field>
                <label>Interest Rate (%)</label>
                <input
                    placeholder="10"
                    onChange={(e) =>
                        setInterestRate(parseFloat(e.target.value))
                    }
                />
            </Form.Field>
            <Form.Field>
                <label>Maximum loan ($)</label>
                <input
                    placeholder="40000"
                    onChange={(e) => setMaximumLoan(parseFloat(e.target.value))}
                />
            </Form.Field>
            <Form.Field>
                <label>Minimum down payment (%)</label>
                <input
                    placeholder="10"
                    onChange={(e) =>
                        setMinimumDownPayment(parseFloat(e.target.value))
                    }
                />
            </Form.Field>
            <Form.Field>
                <label>Loan term (months)</label>
                <input
                    placeholder="12"
                    onChange={(e) => setLoanTerm(parseInt(e.target.value))}
                />
            </Form.Field>
            <Button type="submit" onClick={postData}>
                Create
            </Button>
        </Form>
    );
}

export default Create;
