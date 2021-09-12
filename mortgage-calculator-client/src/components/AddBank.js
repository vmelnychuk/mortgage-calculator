import React, { Component } from 'react';

export default class AddBank extends Component {
    submitBank(event) {
        event.preventDefault();

        let bank = {
            name: this.refs.name.value,
            interestRate: this.refs.interestRate.value,
            maximumLoan: this.refs.maximumLoan.value,
            minimumDownPayment: this.refs.minimumDownPayment.value,
            loanTerm: this.refs.loanTerm.value,
        }

        fetch("http://localhost:8080/api/banks", {
            method: "POST",
            headers: {
                "content-type": "application/json",
            },
            body: JSON.stringify(bank),
        })
            .then(response => response.json());

        window.location.reload();
    }

    render() {
        return (
            <div className="row">
                <form className="col s12" onSubmit={this.submitBank.bind(this)}>
                    <div className="row">
                        <div className="input-field col s6">
                            <input placeholder="Placeholder" ref="name" type="text" className="validate" />
                            <label htmlFor="name">Bank name</label>
                        </div>
                        <div className="input-field col s6">
                            <input ref="interestRate" type="text" className="validate" />
                            <label htmlFor="interestRate">Interest rate</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="input-field col s12">
                            <input ref="maximumLoan" type="text" className="validate" />
                            <label htmlFor="maximumLoan">Maximum loan amount</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="input-field col s12">
                            <input ref="minimumDownPayment" type="text" className="validate" />
                            <label htmlFor="minimumDownPayment">Minimum down payment amount</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="input-field col s12">
                            <input ref="loanTerm" type="text" className="validate" />
                            <label htmlFor="loanTerm">Loan term</label>
                        </div>
                    </div>
                    <div className="row">
                        <button className="waves-effect waves-light btn" type="submit" name="action">Submit</button>
                    </div>
                </form>
            </div>
        )
    }
}
