import React from 'react';


class NewCustomerForm extends React.Component {
	constructor(props) {
		super(props);
		this.state = { name: "", id: "1234" };
		this.handleNameChange = this.handleNameChange.bind(this);
		this.handleIdChange = this.handleIdChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleNameChange(event) { this.setState({ name: event.target.value }); }
	handleIdChange(event) { this.setState({ id: event.target.value }); }
	handleSubmit(event) {
		console.log('Name was submitted: ' + this.state.name);
		event.preventDefault();
		fetch('http://localhost:8080/customer', {
			method: "POST", // *GET, POST, PUT, DELETE, etc.
			mode: "cors", // no-cors, *cors, same-origin
			cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
			credentials: "same-origin", // include, *same-origin, omit
			headers: {
				"Content-Type": "application/json",
				// 'Content-Type': 'application/x-www-form-urlencoded',
			},
			redirect: "follow", // manual, *follow, error
			referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
			body: JSON.stringify({ name: this.state.name, id: this.state.id }), // body data type must match "Content-Type" header
		})
			.then(response => response.text()) // Read response as text
			.then(data => {
				console.log("data returned = " + data);
			})
	}

	render() {
		return (
			<form onSubmit={this.handleSubmit}>
				<label>
					Name:
					<input value={this.state.name} onChange={this.handleNameChange} />        </label>
				<label>
					ID:
					<input value={this.state.id} onChange={this.handleIdChange} />        </label>
				<input type="submit" value="Submit" />
			</form>
		);
	}
}

export default NewCustomerForm